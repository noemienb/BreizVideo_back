package noemie.breiznoemie.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface VillageService {
    List<Village> listVillages(String search);
    Optional<Village> getVillage(Long id);
    Village insertVillage(Village village);
    Village updateVillage(Long id, Village village);
    void deleteVillage(Long id);

}
