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
    public void testUpdateDoctor() {
        Doctor doctor = new Doctor("D001", "Dr. John Doe", "Cardiology");
        management.addDoctor(doctor);
        Doctor updatedDoctor = new Doctor("D001", "Dr. Jane Smith", "Pediatrics");
        management.updateDoctor(updatedDoctor);
        assertEquals(updatedDoctor, management.getDoctorById("D001"));
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

}
