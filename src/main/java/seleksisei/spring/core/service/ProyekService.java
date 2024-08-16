package seleksisei.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seleksisei.spring.core.dto.LokasiDTO;
import seleksisei.spring.core.dto.ProyekLokasiDTO;
import seleksisei.spring.core.model.Proyek;
import seleksisei.spring.core.repository.LokasiRepository;
import seleksisei.spring.core.repository.ProyekRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyekService {

	@Autowired
	private ProyekRepository proyekRepository;

	@Autowired
	private LokasiRepository lokasiRepository;

	public List<Proyek> findAll() {
		return proyekRepository.findAll();
	}

	public Optional<Proyek> findById(Integer id) {
		return proyekRepository.findById(Long.valueOf(id));
	}

	public Proyek save(Proyek proyek) {
		return proyekRepository.save(proyek);
	}

	public void deleteById(Integer id) {
		proyekRepository.deleteById(Long.valueOf(id));
	}

	public ProyekLokasiDTO convertToProyekLokasiDTO(Proyek proyek) {
		ProyekLokasiDTO dto = new ProyekLokasiDTO();
		dto.setNamaProyek(proyek.getNamaProyek());
		dto.setClient(proyek.getClient());
		dto.setTglMulai(proyek.getTglMulai());
		dto.setTglSelesai(proyek.getTglSelesai());
		dto.setPimpinanProyek(proyek.getPimpinanProyek());
		dto.setKeterangan(proyek.getKeterangan());
		dto.setLokasi(proyek.getLokasi().stream()
			.map(lokasi -> new LokasiDTO(lokasi.getId(), lokasi.getNamaLokasi()))
			.collect(Collectors.toSet()));
		return dto;
	}

	public List<ProyekLokasiDTO> getProyekLokasi() {
		// Implementasi untuk mengambil semua proyek dan lokasi jika diperlukan
		return proyekRepository.findAll().stream()
			.map(this::convertToProyekLokasiDTO)
			.collect(Collectors.toList());
	}
}
