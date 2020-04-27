package br.com.slc.service;

import br.com.slc.converter.SlcRequestConverter;
import br.com.slc.exception.BadRequestException;
import br.com.slc.model.BcMsg;
import br.com.slc.model.GrupoSlcLiquid;
import br.com.slc.model.GrupoSlcLiquidProdt;
import br.com.slc.model.GrupoSlcProdt;
import br.com.slc.model.SisMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author João Paulo Santarém
 */
@RunWith(PowerMockRunner.class)
public class DocUploadServiceTest {

  @InjectMocks
  private DocUploadService docUploadService;

  @Spy
  private SlcRequestConverter slcRequestConverter = new SlcRequestConverter();

  @Mock
  private BcMsgService bcMsgService;

  @Mock
  private SisMsgService sisMsgService;

  @Captor
  private ArgumentCaptor<BcMsg> bcMsgCaptor;

  @Captor
  private ArgumentCaptor<SisMsg> sisMsgCaptor;

  @Test
  public void shouldUploadXmlFile() throws IOException {
    MultipartFile multipartFile = getMultipartFile();
    docUploadService.upload(multipartFile);

    verify(bcMsgService, times(1)).save(bcMsgCaptor.capture());
    verify(sisMsgService, times(1)).save(sisMsgCaptor.capture());

    BcMsg bcMsgResult = bcMsgCaptor.getValue();
    SisMsg sisMsgResult = sisMsgCaptor.getValue();

    // assert BcMsg
    assertNotNull(bcMsgResult);
    assertEquals(Long.valueOf(99999999), bcMsgResult.getIdentdEmissor());
    assertEquals(Long.valueOf(12345678), bcMsgResult.getIdentdDestinatario());
    assertNotNull(bcMsgResult.getGrupoSeqs());
    assertEquals("SPB01", bcMsgResult.getDomSist());
    assertEquals("12345678912345678912345", bcMsgResult.getnUOp());

    // assert GrupoSeq
    assertEquals(Long.valueOf(1), bcMsgResult.getGrupoSeqs().getNumSeq());
    assertEquals('N', bcMsgResult.getGrupoSeqs().getIndrCont());

    // assert SisMsg
    assertNotNull(sisMsgResult);

    // assert Slc
    assertNotNull(sisMsgResult.getSlc());
    assertEquals("SLC0001", sisMsgResult.getSlc().getCodMsg());
    assertEquals("12345678912345678912", sisMsgResult.getSlc().getNumCtrlSLC());
    assertEquals(Long.valueOf(12345678), sisMsgResult.getSlc().getIspBif());
    assertEquals('P', sisMsgResult.getSlc().getTpInf());
    assertNotNull(sisMsgResult.getSlc().getGrupoSlcLiquid());
    assertEquals(LocalDateTime.parse("2019-01-01T08:40:21"), sisMsgResult.getSlc().getDtHrSlc());
    assertEquals(LocalDate.parse("2019-01-01"), sisMsgResult.getSlc().getDtMovto());

    // assert GrupoSlcLiquid
    GrupoSlcLiquid grupoSlcLiquid = sisMsgResult.getSlc().getGrupoSlcLiquid();
    assertEquals(LocalDate.parse("2019-01-01"), grupoSlcLiquid.getDtLiquid());
    assertEquals(Integer.valueOf(1), grupoSlcLiquid.getNumSeqCicloLiquid());
    assertNotNull(sisMsgResult.getSlc().getGrupoSlcLiquid().getGrupoSlcProdts());

    // assert GrupoSlcProdt
    List<GrupoSlcProdt> grupoSlcProdts = sisMsgResult.getSlc().getGrupoSlcLiquid().getGrupoSlcProdts();
    assertEquals(4, grupoSlcProdts.size());
    // position 0 - grupoSlcLiquidProdt
    GrupoSlcProdt grupoSlcProdt = grupoSlcProdts.stream()
        .filter(g -> "ACC".equals(g.getCodProdt()))
        .findFirst()
        .orElse(null);
    assertNotNull(grupoSlcProdt);
    assertEquals(1, grupoSlcProdt.getGrupoSlcLiquidProdts().size());
    GrupoSlcLiquidProdt grupoSlcLiquidProdt = grupoSlcProdt.getGrupoSlcLiquidProdts().get(0);

    assertEquals("12345678ACC3456789", grupoSlcLiquidProdt.getIdentdLinhaBilat());
    assertEquals('D', grupoSlcLiquidProdt.getTpDebCred());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt.getIspbifcCredtd());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt.getIspbifDebtd());
    assertEquals(0, BigDecimal.valueOf(4000.00).compareTo(grupoSlcLiquidProdt.getVlrLanc()));
    assertEquals("99929009000149", grupoSlcLiquidProdt.getCnpjNLiqdantDebtd());
    assertEquals("JET", grupoSlcLiquidProdt.getNomCliDebtd());
    assertEquals("17061147000194", grupoSlcLiquidProdt.getCnpjNLiqdantCredtd());
    assertEquals("BANCO", grupoSlcLiquidProdt.getNomCliCredtd());
    assertEquals("02", grupoSlcLiquidProdt.getTpTranscSlc());

    // position 1
    GrupoSlcProdt grupoSlcProdt1 = grupoSlcProdts.stream().filter(g -> "VCC".equals(g.getCodProdt()))
        .findFirst()
        .orElse(null);
    assertNotNull(grupoSlcProdt1);
    assertEquals(2, grupoSlcProdt1.getGrupoSlcLiquidProdts().size());

    // grupoSlcLiquidProdt 1.1
    GrupoSlcLiquidProdt grupoSlcLiquidProdt11 = grupoSlcProdt1.getGrupoSlcLiquidProdts().stream()
        .filter(g -> "12345678VCC3456789".equals(g.getIdentdLinhaBilat()))
        .findFirst().orElse(null);

    assertNotNull(grupoSlcLiquidProdt11);
    assertEquals('C', grupoSlcLiquidProdt11.getTpDebCred());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt11.getIspbifcCredtd());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt11.getIspbifDebtd());
    assertEquals(BigDecimal.valueOf(16990.85), grupoSlcLiquidProdt11.getVlrLanc());
    assertEquals("47515515000198", grupoSlcLiquidProdt11.getCnpjNLiqdantDebtd());
    assertEquals("BANCOBOB", grupoSlcLiquidProdt11.getNomCliDebtd());
    assertEquals("02181332000145", grupoSlcLiquidProdt11.getCnpjNLiqdantCredtd());
    assertEquals("BANCO", grupoSlcLiquidProdt11.getNomCliCredtd());
    assertEquals("02", grupoSlcLiquidProdt11.getTpTranscSlc());

    // grupoSlcLiquidProdt 1.2
    GrupoSlcLiquidProdt grupoSlcLiquidProdt12 = grupoSlcProdt1.getGrupoSlcLiquidProdts().stream()
        .filter(g -> "10045678VCC3456789".equals(g.getIdentdLinhaBilat()))
        .findFirst().orElse(null);
    assertNotNull(grupoSlcLiquidProdt12);
    assertEquals('C', grupoSlcLiquidProdt12.getTpDebCred());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt12.getIspbifcCredtd());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt12.getIspbifDebtd());
    assertEquals(BigDecimal.valueOf(3171.76), grupoSlcLiquidProdt12.getVlrLanc());
    assertEquals("50276286000100", grupoSlcLiquidProdt12.getCnpjNLiqdantDebtd());
    assertEquals("TRIANGULO", grupoSlcLiquidProdt12.getNomCliDebtd());
    assertEquals("23333472000161", grupoSlcLiquidProdt12.getCnpjNLiqdantCredtd());
    assertEquals("BANCO", grupoSlcLiquidProdt12.getNomCliCredtd());
    assertEquals("02", grupoSlcLiquidProdt12.getTpTranscSlc());

    // position 2
    GrupoSlcProdt grupoSlcProdt2 = grupoSlcProdts.stream().filter(g -> "MCC".equals(g.getCodProdt()))
        .findFirst()
        .orElse(null);
    assertNotNull(grupoSlcProdt2);
    assertNotNull(grupoSlcProdt2.getGrupoSlcLiquidProdts());
    assertEquals(1, grupoSlcProdt2.getGrupoSlcLiquidProdts().size());

    // grupoSlcLiquidProdt
    final GrupoSlcLiquidProdt grupoSlcLiquidProdt2 = grupoSlcProdt2.getGrupoSlcLiquidProdts().get(0);
    assertEquals("12345678MCC1633000", grupoSlcLiquidProdt2.getIdentdLinhaBilat());
    assertEquals('C', grupoSlcLiquidProdt2.getTpDebCred());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt2.getIspbifcCredtd());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt2.getIspbifDebtd());
    assertEquals(BigDecimal.valueOf(5462.12), grupoSlcLiquidProdt2.getVlrLanc());
    assertEquals("93052785000127", grupoSlcLiquidProdt2.getCnpjNLiqdantDebtd());
    assertEquals("TRIANGULOBOB", grupoSlcLiquidProdt2.getNomCliDebtd());
    assertEquals("07284171000139", grupoSlcLiquidProdt2.getCnpjNLiqdantCredtd());
    assertEquals("BANCO", grupoSlcLiquidProdt2.getNomCliCredtd());
    assertEquals("02", grupoSlcLiquidProdt2.getTpTranscSlc());

    // position 3
    GrupoSlcProdt grupoSlcProdt3 = grupoSlcProdts.stream().filter(g -> "CBC".equals(g.getCodProdt()))
        .findFirst()
        .orElse(null);
    assertNotNull(grupoSlcProdt3);
    assertNotNull(grupoSlcProdt3.getGrupoSlcLiquidProdts());
    assertEquals(1, grupoSlcProdt3.getGrupoSlcLiquidProdts().size());

    // grupoSlcLiquidProdt
    final GrupoSlcLiquidProdt grupoSlcLiquidProdt3 = grupoSlcProdt3.getGrupoSlcLiquidProdts().get(0);
    assertEquals("12345678CBC1633012", grupoSlcLiquidProdt3.getIdentdLinhaBilat());
    assertEquals('C', grupoSlcLiquidProdt3.getTpDebCred());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt3.getIspbifcCredtd());
    assertEquals(Long.valueOf(99999999), grupoSlcLiquidProdt3.getIspbifDebtd());
    assertEquals(BigDecimal.valueOf(21446.69), grupoSlcLiquidProdt3.getVlrLanc());
    assertEquals("74816392000106", grupoSlcLiquidProdt3.getCnpjNLiqdantDebtd());
    assertEquals("BANCOBOB", grupoSlcLiquidProdt3.getNomCliDebtd());
    assertEquals("30101382000100", grupoSlcLiquidProdt3.getCnpjNLiqdantCredtd());
    assertEquals("TRIANGULOBANCO", grupoSlcLiquidProdt3.getNomCliCredtd());
    assertEquals("02", grupoSlcLiquidProdt3.getTpTranscSlc());
  }

  @Test(expected = BadRequestException.class)
  public void throwErrorIfFileIsInvalid() {
    MultipartFile multipartFile = new MockMultipartFile("slc", "slc.xml", "text/plain", "test".getBytes());
    docUploadService.upload(multipartFile);
  }

  public MultipartFile getMultipartFile() throws IOException {
    File file = new ClassPathResource("SLC0001-modelo.xml").getFile();
    FileInputStream fileInputStream = new FileInputStream(file);

    return new MockMultipartFile(file.getName(), file.getName(), "text/plain", fileInputStream);
  }
}
