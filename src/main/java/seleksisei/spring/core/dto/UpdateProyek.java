package seleksisei.spring.core.dto;

import lombok.Data;

import java.util.Set;
@Data
public class UpdateProyek {
	private String namaProyek;
	private String client;
	private String tglMulai;
	private String tglSelesai;
	private String pimpinanProyek;
	private String keterangan;
	private Set<String> lokasi;  // Field untuk lokasi

	// Getters and Setters
	public String getNamaProyek() {
		return namaProyek;
	}

	public void setNamaProyek(String namaProyek) {
		this.namaProyek = namaProyek;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String  getTglMulai() {
		return tglMulai;
	}

	public void setTglMulai(String tglMulai) {
		this.tglMulai = String.valueOf(tglMulai);
	}

	public String getTglSelesai() {
		return tglSelesai;
	}

	public void setTglSelesai(String tglSelesai) {
		this.tglSelesai = tglSelesai;
	}

	public String getPimpinanProyek() {
		return pimpinanProyek;
	}

	public void setPimpinanProyek(String pimpinanProyek) {
		this.pimpinanProyek = pimpinanProyek;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public Set<String> getLokasi() {
		return lokasi;
	}

	public void setLokasi(Set<String> lokasi) {
		this.lokasi = lokasi;
	}
}
