package dragonfly.architect.services.org.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable UUID personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID personId) {
        if (personRepository.existsById(personId)) {
            personRepository.deleteById(personId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{personId}/work-profile")
    public ResponseEntity<WorkProfile> getWorkProfileByPersonId(@PathVariable UUID personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent() && person.get().getWorkProfile() != null) {
            return ResponseEntity.ok(person.get().getWorkProfile());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{personId}/phone-numbers")
    public ResponseEntity<List<PhoneNumber>> getPhoneNumbersByPersonId(@PathVariable UUID personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent() && person.get().getPhoneNumbers() != null) {
            return ResponseEntity.ok(person.get().getPhoneNumbers());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{personId}/addresses")
    public ResponseEntity<List<Address>> getAddressesByPersonId(@PathVariable UUID personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent() && person.get().getAddresses() != null) {
            return ResponseEntity.ok(person.get().getAddresses());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
