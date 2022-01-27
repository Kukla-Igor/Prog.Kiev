package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Transactional
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Transactional
    public void deleteGroup(long id) {
        groupRepository.delete(id);
    }

    @Transactional
    public void deleteContacts(long[] idList) {
        for (long id : idList) {
            contactRepository.delete(id);
        }
    }

    @Transactional(readOnly=true)
    public List<Group> findGroups() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Contact> findAll(Pageable pageable) {
        return contactRepository
                .findAll(pageable).getContent();
    }



    @Transactional(readOnly=true)
    public List<Contact> findByGroup(Group group, Pageable pageable) {
        return contactRepository.findByGroup(group, pageable);
    }

    @Transactional(readOnly = true)
    public long countByGroup(Group group) {
        return contactRepository.countByGroup(group);
    }

    @Transactional(readOnly=true)
    public List<Contact> findByPattern(String pattern, Pageable pageable) {
        return contactRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly = true)
    public long count() {
        return contactRepository.count();
    }

    @Transactional(readOnly=true)
    public Group findGroup(long id) {
        return groupRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public File contactsToJson() {
        String path = "C:\\Users\\Samog\\Desktop\\Tets\\Contacts.json";
        List<Contact> contacts = findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try (FileWriter writer = new FileWriter(path)) {
            for (Contact contact: contacts) {
               gson.toJson(contact, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    public String contactsToXML() {
        String path = "C:\\Users\\Samog\\Desktop\\Tets\\Contacts.xml";
        List<Contact> contacts = findAll();
        XStream xstream = new XStream();

        try (FileWriter writer = new FileWriter(path)) {
            xstream.toXML(contacts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
