package nvc.it.icefactorypantira.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.icefactorypantira.model.Camera;
import nvc.it.icefactorypantira.model.Event;
import nvc.it.icefactorypantira.repository.CameraRepository;

@Service
public class CameraService {
    @Autowired
    private CameraRepository cameraRepository; 

    public List<Camera> getCameras(){
        return cameraRepository.findAll();
    }

    public Optional<Camera> findById(String id){
        return cameraRepository.findById(id);
    }

    // public List<Camera> findProductByName(String name){
    //     return cameraRepository.findByNameContaining(name);
    // }
 
    // Add 
    public Camera addCamera(Camera camera){
        return cameraRepository.save(camera);
    }

    // Update                           รับข้อมูล , ข้อมูลที่อัพเดตแล้ว
    public Optional<Camera> updateCamera(String id, Camera camera){
        // Get Camera เดิม จาก ID
        Camera currentCamera = cameraRepository.findById(id).get();
        // Change Data
        currentCamera.setName(camera.getName());
        currentCamera.setLocation(camera.getLocation());
        // Send ค่ากลับไป
        return Optional.of(cameraRepository.save(currentCamera));
    }

    // Add Event ทำคล้าย การupdate
    public Optional<Camera> addEvents(String id, Event event){
        Camera currentCamera = cameraRepository.findById(id).get();
        List<Event> events = currentCamera.getEvents();
        event.setCreatedAt(new Date(System.currentTimeMillis()));
        events.add(event);
        currentCamera.setEvents(events);
        return Optional.of(cameraRepository.save(currentCamera));
    }
    // Delete 
    public Boolean deleteCamera(String id){
        try {
            cameraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
