package lk.ijse.service.impl;

import lk.ijse.dto.CatagoryDTO;
import lk.ijse.entity.Catagory;
import lk.ijse.exeption.ValidateException;
import lk.ijse.repo.CatagoryRepo;
import lk.ijse.service.CatagoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepo catagoryRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addCatagory(CatagoryDTO dto) {

        if (catagoryRepo.existsById(dto.getCategoryID())){
            throw new ValidateException("Category already exists");
        }

        Catagory catagory = modelMapper.map(dto,Catagory.class);
        catagoryRepo.save(catagory);
    }

    @Override
    public void deleteCuatagory(String id) {
        if (!catagoryRepo.existsById(id)) {
            //throw new ValidateException("No Customer for Delete..!");
        }
        catagoryRepo.deleteById(id);

    }

    @Override
    public CatagoryDTO searchCatagory(String id) {
        Optional<Catagory> catagory = catagoryRepo.findById(id);
        if (catagory.isPresent()) {
            return modelMapper.map(catagory.get(), CatagoryDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CatagoryDTO> getAllCatagory() {
        List<Catagory> all = catagoryRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<CatagoryDTO>>() {
        }.getType());
    }

    @Override
    public void updateCatagory(CatagoryDTO dto) {
        if (catagoryRepo.existsById(dto.getCategoryID())) {
            catagoryRepo.save(modelMapper.map(dto, Catagory.class));


        }
    }
}