package com.vilaka.saveentityassociateforone.services;

import com.vilaka.saveentityassociateforone.dto.PersonDepartmentDTO;
import com.vilaka.saveentityassociateforone.entities.Department;
import com.vilaka.saveentityassociateforone.entities.Person;
import com.vilaka.saveentityassociateforone.repositories.DepartmentRepository;
import com.vilaka.saveentityassociateforone.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;

      @Transactional
      public PersonDepartmentDTO insert(PersonDepartmentDTO dto){
        //Copiar dto para entidade
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Copiar departamentoDTO para entidade departamento
         Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        //Department dept = new Department();
        dept.setId(dto.getDepartment().getId());

        //Associar entidade departamento à variável da entidade
        entity.setDepartment(dept);

        entity = repository.save(entity);

        return new PersonDepartmentDTO(entity);
    }

}
