package com.usa.ciclo3.retociclo3.service;

import com.usa.ciclo3.retociclo3.model.Quadbike;
import com.usa.ciclo3.retociclo3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuadbikeService {
    @Autowired
    private QuadbikeRepository quadbikeRepository;

    public List<Quadbike> getAll() {
        return quadbikeRepository.getAll();
    }

    public Optional<Quadbike> getQuadbike(int id) {
        return quadbikeRepository.getQuadbike(id);
    }

    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return quadbikeRepository.save(quadbike);
        } else {
            Optional<Quadbike> tmpQuadbike = quadbikeRepository.getQuadbike(quadbike.getId());
            if (tmpQuadbike.isEmpty()) {
                return quadbikeRepository.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }

    public Quadbike update(Quadbike quadbike){
        if(quadbike.getId()!=null){
            Optional<Quadbike> e=quadbikeRepository.getQuadbike(quadbike.getId());
            if(!e.isEmpty()){
                if(quadbike.getName()!=null){
                    e.get().setName(quadbike.getName());
                }
                if(quadbike.getBrand()!=null){
                    e.get().setBrand(quadbike.getBrand());
                }
                if(quadbike.getYear() !=null){
                    e.get().setYear(quadbike.getYear());
                }
                if(quadbike.getDescription()!=null){
                    e.get().setDescription(quadbike.getDescription());
                }
                if(quadbike.getCategory()!=null){
                    e.get().setCategory(quadbike.getCategory());
                }
                quadbikeRepository.save(e.get());
                return e.get();
            }else{
                return quadbike;
            }
        }else{
            return quadbike;
        }
    }

    public boolean deleteQuadbike(int id){
        Boolean aBoolean=getQuadbike(id).map(quadbike -> {
            quadbikeRepository.delete(quadbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
