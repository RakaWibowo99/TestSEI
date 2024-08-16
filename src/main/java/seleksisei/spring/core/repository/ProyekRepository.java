package seleksisei.spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seleksisei.spring.core.dto.ProyekLokasiDTO;
import seleksisei.spring.core.model.Proyek;

import java.util.List;

public interface ProyekRepository extends JpaRepository<Proyek, Long> {

	@Query(value = "SELECT p.nama_proyek, p.client, p.tgl_mulai, p.tgl_selesai, p.pimpinan_proyek, p.keterangan, " +
		"l.nama_lokasi, l.negara, l.provinsi, l.kota " +
		"FROM proyek p " +
		"JOIN proyek_lokasi pl ON p.id = pl.proyek_id " +
		"JOIN lokasi l ON pl.lokasi_id = l.id " +
		"ORDER BY p.nama_proyek", nativeQuery = true)
	List<ProyekLokasiDTO> findProyekLokasi();
}
