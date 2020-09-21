package com.sda.jpademo;

import com.sda.jpademo.model.Gender;
import com.sda.jpademo.model.Person;
import com.sda.jpademo.model.Phone;
import com.sda.jpademo.repository.PersonRepo;
import com.sda.jpademo.repository.PhoneRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args).close();
	}

	private PersonRepo personRepo;
	private PhoneRepo phoneRepo;

	public JpaDemoApplication(PersonRepo personRepo, PhoneRepo phoneRepo) {
		this.personRepo = personRepo;
		this.phoneRepo = phoneRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("###### START #######");

		System.out.println("==== INIT ===");
		personRepo.save(new Person("unknown","unknown",0 , null));
		personRepo.save(new Person("anna","zzz",33 , Gender.FEMALE));
		personRepo.save(new Person("jozef","yyy",16 , Gender.MALE));
		personRepo.save(new Person("adolf","xxx",26 , Gender.MALE));
		personRepo.findAll().forEach(System.out::println);

		phoneRepo.save(new Phone("1233456", personRepo.findById(3L).orElse(new Person(1L))));
		phoneRepo.save(new Phone("8070987", personRepo.findById(3L).orElse(new Person(1L))));
		phoneRepo.save(new Phone("6543211", personRepo.findById(4L).orElse(new Person(1L))));
		phoneRepo.save(new Phone("4643511", personRepo.findById(5L).orElse(new Person(1L))));
		phoneRepo.findAll().forEach(System.out::println);

		System.out.println("==== Phones By Person Id : 3 ===");
		phoneRepo.findAllByOwnerId(3L).forEach(System.out::println);
		phoneRepo.findAllByOwner(personRepo.findById(3L).orElse(new Person(1L))).forEach(System.out::println);
		System.out.println("==== Person By LastName : xxx  ===");
		personRepo.findAllByLastName("xxx").forEach(System.out::println);

		System.out.println("==== Phones By Number Ending : 11 ===");
		phoneRepo.findAllByNumberEndingWith("11").forEach(System.out::println);
		phoneRepo.findAllByNumberLike("%11").forEach(System.out::println);

		System.out.println("###### END #######");

	}
}
