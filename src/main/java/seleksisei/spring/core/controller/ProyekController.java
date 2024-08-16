package seleksisei.spring.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seleksisei.spring.core.dto.ProyekLokasiDTO;
import seleksisei.spring.core.dto.UpdateProyek;
import seleksisei.spring.core.model.Lokasi;
import seleksisei.spring.core.model.Proyek;
import seleksisei.spring.core.repository.LokasiRepository;
import seleksisei.spring.core.repository.ProyekRepository;
import seleksisei.spring.core.service.ProyekService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

	@Autowired
	private ProyekRepository proyekRepository;

	@Autowired
	private LokasiRepository lokasiRepository;

	@Autowired
	private ProyekService proyekService;

	@PostMapping
	public ResponseEntity<Proyek> addProyek(@RequestBody UpdateProyek proyekDTO) {
		System.out.println(proyekDTO);
		Proyek proyek = new Proyek();
		proyek.setNamaProyek(proyekDTO.getNamaProyek());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		proyek.setClient(proyekDTO.getClient());
		proyek.setTglMulai(LocalDate.parse(proyekDTO.getTglMulai(), formatter));
		proyek.setTglSelesai(LocalDate.parse(proyekDTO.getTglSelesai(), formatter));
		proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
		proyek.setKeterangan(proyekDTO.getKeterangan());
		proyek.setCreatedAt(LocalDateTime.now());

		Set<Lokasi> lokasiSet = new HashSet<>();
		for (String idlokasi : proyekDTO.getLokasi()) {
			Integer idlokasiInt = Integer.parseInt(idlokasi);
			Optional<Lokasi> lokasiOptional = lokasiRepository.findById(idlokasiInt);
			lokasiOptional.ifPresent(lokasiSet::add);
		}
		proyek.setLokasi(lokasiSet);

		Proyek savedProyek = proyekRepository.save(proyek);
		return ResponseEntity.ok(savedProyek);
	}

	@GetMapping
	public List<Proyek> getAllProyek() {
		return proyekService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proyek> getProyekById(@PathVariable Integer id) {
		Proyek proyek = proyekService.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));
		return ResponseEntity.ok(proyek);
	}

	@GetMapping("/proyek-lokasi/{id}")
	public ResponseEntity<ProyekLokasiDTO> getProyekLokasiById(@PathVariable Integer id) {
		Proyek proyek = proyekService.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));

		ProyekLokasiDTO dto = proyekService.convertToProyekLokasiDTO(proyek);
		return ResponseEntity.ok(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody UpdateProyek proyekDetails) {
		System.out.println("Proyek Details");
		System.out.println(proyekDetails);
		Proyek proyek = proyekService.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));

		proyek.setNamaProyek(proyekDetails.getNamaProyek());
		proyek.setClient(proyekDetails.getClient());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		proyek.setTglMulai(LocalDate.parse(proyekDetails.getTglMulai(), formatter));
		proyek.setTglSelesai(LocalDate.parse(proyekDetails.getTglSelesai(), formatter));
		proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
		proyek.setKeterangan(proyekDetails.getKeterangan());

		Set<Lokasi> lokasiSet = new HashSet<>(proyek.getLokasi());

		for (String idlokasi : proyekDetails.getLokasi()) {
			Integer idlokasiInt = Integer.parseInt(idlokasi);
			Optional<Lokasi> lokasiOptional = lokasiRepository.findById(idlokasiInt);
			lokasiOptional.ifPresent(lokasiSet::add);
		}

		proyek.setLokasi(lokasiSet);

		final Proyek updatedProyek = proyekService.save(proyek);
		return ResponseEntity.ok(updatedProyek);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProyek(@PathVariable Integer id) {
		proyekService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
