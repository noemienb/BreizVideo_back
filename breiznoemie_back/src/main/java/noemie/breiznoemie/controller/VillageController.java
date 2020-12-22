package noemie.breiznoemie.controller;

import com.noemie.breiznoemie.model.Village;
import com.noemie.breiznoemie.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;
import java.util.Optional;

public class VillageController {

    @Autowired
    VillageService villageService;

    @GetMapping("/village")
    public List<Village> getVillage() {
        return villageService.listVillage("");
    }
    public ResponseEntity<List<Village>> getVillage(@RequestParam(value="search", defaultValue="") String search) {
        List<Village> listVillage;
        try {
            listVillage = villageService.listVillage(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listVillage);
    }

    @GetMapping("/village/{id}")
    ResponseEntity<Village> getVillageById(@PathVariable(value="id") long id) {
        Optional<Village> village = villageService.getVillage(id);
        if (village.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(village.get());
    }
    @GetMapping("/village/{post_code}")
    ResponseEntity<Village> getVillageByPost_code(@PathVariable(value="post_code") long post_code) {
        Optional<Village> village = villageService.getVillage(post_code);
        if (village.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(village.get());
    }
    @PostMapping("/village")
    public Village postVillage(@RequestBody Village village){
        return villageService.insertVillage(village);
    }




}
