package seleksisei.spring.core.service;

import seleksisei.spring.core.model.Lokasi;
import seleksisei.spring.core.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> findById(Integer id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi save(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public void deleteById(Integer id) {
        lokasiRepository.deleteById(id);
    }
}
