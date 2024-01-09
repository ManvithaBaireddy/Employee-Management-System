package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/departments")
@RestController
public class DepartmentController {

    private DepartmentService departmentService;
@PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department,HttpStatus.CREATED );
    }
@GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
    DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
    return ResponseEntity.ok(departmentDto);
    }
@GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
    List<DepartmentDto> departments = departmentService.getAllDepartments();
    return ResponseEntity.ok(departments);
    }
@PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable("id") Long departmentId,
                                                         @RequestBody DepartmentDto updatedDeparetment){
    DepartmentDto departmentDto =  departmentService.updateDepartment(departmentId , updatedDeparetment);
    return ResponseEntity.ok(departmentDto);
    }
@DeleteMapping("{id}")
    public ResponseEntity<String>deleteDepartment(@PathVariable("id") Long departmentId){
    departmentService.deleteDepartment(departmentId);
    return ResponseEntity.ok("Departmrnt deleted successfully");
    }

}
