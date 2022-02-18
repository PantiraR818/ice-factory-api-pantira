package nvc.it.icefactorypantira.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.icefactorypantira.model.Camera;

public interface CameraRepository extends MongoRepository<Camera,String> {
    
}
