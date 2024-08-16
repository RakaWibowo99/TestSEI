package seleksisei.spring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyekLokasiDTO {
	private String namaProyek;
	private String client;
	private LocalDate tglMulai;
	private LocalDate tglSelesai;
	private String pimpinanProyek;
	private String keterangan;
	private String namaLokasi;
	private String negara;
	private String provinsi;
	private String kota;


	public void setLokasi(Set<LokasiDTO> collect) {
		// TODO Auto-generated method stub

	}
}
