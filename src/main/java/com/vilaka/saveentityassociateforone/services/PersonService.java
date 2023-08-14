package com.vilaka.saveentityassociateforone.services;

import com.vilaka.saveentityassociateforone.dto.PersonDTO;
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
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

        Person entity = new Person();

        //Copiar dto para entidade
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Copiar departamentoDTO para entidade departamento
        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        //Department dept = new Department();
        //dept.setId(dto.getDepartment().getId());

        //Associar entidade departamento à variável da entidade
        entity.setDepartment(dept);

        entity = repository.save(entity);

        return new PersonDepartmentDTO(entity);
    }

    @Transactional
    public PersonDTO insert(PersonDTO dto){
        Person entity = new Person();

        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Department dpt = departmentRepository.getReferenceById(dto.getDepartmentId());

        Department dpt = new Department();
        dpt.setId(dto.getDepartmentId());

        entity.setDepartment(dpt);

        entity = repository.save(entity);

        return new PersonDTO(entity);

    }

}
