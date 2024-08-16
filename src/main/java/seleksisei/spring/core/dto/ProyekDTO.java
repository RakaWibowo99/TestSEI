package seleksisei.spring.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Set;

public class ProyekDTO {
	private String namaProyek;
	private String client;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime tglMulai;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime tglSelesai;
	private String pimpinanProyek;
	private String keterangan;
	private Set<LokasiDTO> lokasi;  // Field untuk lokasi

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

	public LocalDateTime getTglMulai() {
		return tglMulai;
	}

	public void setTglMulai(LocalDateTime tglMulai) {
		this.tglMulai = tglMulai;
	}

	public LocalDateTime getTglSelesai() {
		return tglSelesai;
	}

	public void setTglSelesai(LocalDateTime tglSelesai) {
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

	public Set<LokasiDTO> getLokasi() {
		return lokasi;
	}

	public void setLokasi(Set<LokasiDTO> lokasi) {
		this.lokasi = lokasi;
	}
}
