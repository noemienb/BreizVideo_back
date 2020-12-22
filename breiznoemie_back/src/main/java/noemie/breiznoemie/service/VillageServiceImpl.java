package noemie.breiznoemie.service;
import com.noemie.breiznoemie.model.Village;
import com.noemie.breiznoemie.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class VillageServiceImpl implements VillageService {


        @Autowired
        private VillageRepository repository;

        @Override
        public List<Village> findAll(String search) {
            if (! "".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();

        }
        @Override
        public Optional<Village> findById(Long id) {
            return repository.findById(id);
        }
        @Override
        public Village insert(Village village) {
            return repository.save(village);
        }
        @Override
        public Village update(Long id, Village village) {
            Optional<Village> optionalVillage = this.findById(id);
            if(optionalVillage.isPresent()) {
                Village villageToUpdate = optionalVillage.get();
                villageToUpdate.setName(village.getName());
                if (village.getCodePostal()!= null)
                villageToUpdate.setCodePostal(village.getCodePostal());
                return repository.save(village);
            }
            return null;
        }
        @Override
        public void delete(Long id){
            Optional<Village> village = this.findById(id);
            if (village.isPresent()){
            repository.delete(village.get());
        }}}