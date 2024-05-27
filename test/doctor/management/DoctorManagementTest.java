/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor.management;

import java.util.ArrayList;
import org.junit.Test;
//import org.junit.
import static org.junit.Assert.*;

/**
 *
 * @author quang
 */
public class DoctorManagementTest {

    private DoctorManagement management;

    public DoctorManagementTest() {
        this.management = new DoctorManagement();
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        assertTrue(management.getDoctors().contains(doctor));
    }

    @Test
    public void testDeleteDoctor() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        management.deleteDoctorById("D001");
        assertTrue(!management.getDoctors().contains(doctor));
    }
    
    @Test
public void testDeleteDoctorById_ExistingDoctor() {
    Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
    management.addDoctor(doctor);
    management.deleteDoctorById("D001");
    assertFalse(management.getDoctors().contains(doctor));
}

@Test
public void testDeleteDoctorById_NonExistingDoctor() {
    Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
    management.addDoctor(doctor);
    management.deleteDoctorById("D002");
    assertTrue(management.getDoctors().contains(doctor));
}

@Test
public void testUpdateDoctor_ExistingDoctor() {
    Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
    management.addDoctor(doctor);
    Doctor updatedDoctor = new Doctor("D001", "Dr. Jane Smith", "Pediatrics");
    management.updateDoctor(updatedDoctor);
    assertEquals(updatedDoctor, management.getDoctorById("D001"));
}

@Test
public void testUpdateDoctor_NonExistingDoctor() {
    Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
    management.addDoctor(doctor);
    Doctor updatedDoctor = new Doctor("D002", "Dr. Jane Smith", "Pediatrics");
    management.updateDoctor(updatedDoctor);
    assertNull(management.getDoctorById("D002"));
}

    @Test
    public void testSearchDoctors() {
        Doctor doctor1 = new Doctor("D001", "Dr. John Doe", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Jane Smith", "Pediatrics");
        management.addDoctor(doctor1);
        management.addDoctor(doctor2);

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor2);

        assertEquals(doctors, management.searchDoctors("Smith"));
    }

    @Test
    public void testGetDoctorById() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        assertEquals(doctor, management.getDoctorById("D001"));
    }

    @Test
    public void testGetDoctorById_NotFound() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        assertNull(management.getDoctorById("D002"));
    }

    @Test
    public void testSearchDoctors_EmptyResult() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        ArrayList<Doctor> expected = new ArrayList<>();
        assertEquals(expected, management.searchDoctors("Smith"));
    }

    @Test
    public void testSearchDoctors_MultipleResults() {
        Doctor doctor1 = new Doctor("D001", "Dr. John Doe", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Jane Smith", "Pediatrics");
        Doctor doctor3 = new Doctor("D003", "Dr. David Johnson", "Cardiology");
        management.addDoctor(doctor1);
        management.addDoctor(doctor2);
        management.addDoctor(doctor3);

        ArrayList<Doctor> expected = new ArrayList<>();
        expected.add(doctor1);
        expected.add(doctor3);

        assertEquals(expected, management.searchDoctors("Cardiology"));
    }

    //BELOW IS TEST BASIC FUNCTION OF Doctor class
    @Test
    public void testDoctorSetId() {
        Doctor doctor = new Doctor();
        doctor.setId("D001");
        assertEquals("D001", doctor.getId());
    }

    @Test
    public void testDoctorSetName() {
        Doctor doctor = new Doctor();
        doctor.setName("Dr. John Doe");
        assertEquals("Dr. John Doe", doctor.getName());
    }

    @Test
    public void testDoctorSetSpecialization() {
        Doctor doctor = new Doctor();
        doctor.setSpecialization("Cardiology");
        assertEquals("Cardiology", doctor.getSpecialization());
    }

    @Test
    public void testDoctorConstructorWithParameters() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        assertEquals("D001", doctor.getId());
        assertEquals("Dr. John Doe", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
    }

    @Test
    public void testToString() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        String expected = "Doctor{id=D001, name=Dr. John Doe, specialization=Cardiology}";
        assertEquals(expected, doctor.toString());
    }

}
