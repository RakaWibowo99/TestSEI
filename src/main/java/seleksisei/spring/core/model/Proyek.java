package seleksisei.spring.core.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namaProyek;
    private String client;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "proyek_id"),
            inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Lokasi> lokasi;

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

    public void setTglMulai(LocalDate tglMulai) {
        this.tglMulai = tglMulai;
    }

    public void setTglSelesai(LocalDate tglSelesai) {
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

	public Set<Lokasi> getLokasi() {
		return lokasi;
	}

	public void setLokasi(Set<Lokasi> lokasi) {
		this.lokasi = lokasi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public void setCreatedAt(LocalDateTime now) {
		this.createdAt = now;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDate getTglMulai() {

		return tglMulai;
	}

	public LocalDate getTglSelesai() {
		return tglSelesai;
	}
}
