package noemie.breiznoemie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.noemie.breiznoemie.model.Village;
import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
    public List<Village> findByVilleContaining(String name) ;
}
