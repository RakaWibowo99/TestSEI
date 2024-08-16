package seleksisei.spring.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seleksisei.spring.core.model.Lokasi;
import seleksisei.spring.core.service.LokasiService;

import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;

    // Menambahkan data lokasi
    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.save(lokasi);
    }


    // Menampilkan semua data Lokasi dalam bentuk list
    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.findAll();
    }

	@GetMapping("/{id}")
	public Lokasi getLokasiById(@PathVariable Integer id) {
		return lokasiService.findById(id).orElse(null);
	}

    // Update / edit data lokasi
    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasiDetails) {
        Lokasi lokasi = lokasiService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found for this id :: " + id));

        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());

        final Lokasi updatedLokasi = lokasiService.save(lokasi);
        return ResponseEntity.ok(updatedLokasi);
    }

    // Menghapus data lokasi
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Integer id) {
        lokasiService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
