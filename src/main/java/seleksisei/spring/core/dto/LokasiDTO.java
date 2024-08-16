package seleksisei.spring.core.dto;

public class LokasiDTO {
	private Integer id; // ID dari lokasi, bisa null untuk lokasi baru
	private String namaLokasi; // Nama lokasi baru

	public LokasiDTO(Integer id, String namaLokasi) {
		this.id = id;
		this.namaLokasi = namaLokasi;

	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaLokasi() {
		return namaLokasi;
	}

	public void setNamaLokasi(String namaLokasi) {
		this.namaLokasi = namaLokasi;
	}
}
