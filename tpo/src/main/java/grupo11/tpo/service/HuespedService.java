package grupo11.tpo.service;

import grupo11.tpo.entity.Huesped;
import grupo11.tpo.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableMongoRepositories
public class HuespedService {
    @Autowired
    private HuespedRepository huespedRepo;

    public void guardarHuesped(Huesped huesped){
        huespedRepo.save(huesped);
    }
}
