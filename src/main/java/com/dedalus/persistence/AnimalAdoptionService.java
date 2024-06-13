package com.dedalus.persistence;

import com.dedalus.exception.PetUnavailableException;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.PetHolderEntity;
import lombok.NonNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class AnimalAdoptionService {

    @Inject
    EntityManager em;

    @Transactional
    public String adoptAnimal(Long holderID, Long petID) {
        PetHolderEntity holder = em.find(PetHolderEntity.class, holderID);
        if (holder == null) {
            throw new NotFoundException("The pet holder "+holderID+" does not exist");
        }
        AnimalEntity pet = em.find(AnimalEntity.class, petID);
        if (pet == null) {
            throw new NotFoundException("The animal " + petID + " does not exist");
        }
        if (!pet.isAvailable()) {
            throw new PetUnavailableException(petID);
        }
        pet.setPetHolder(holder);
        em.persist(pet);
        em.flush();
        return getThanksMessage(holder, pet.getName());
    }

    private String getThanksMessage(@NonNull PetHolderEntity holder, @NonNull String petName){
        if (petName.equals("Rupert") && holder.getId().equals(1L)){
            return "Herzlichen Glückwunsch. \n" +
                    "Markus hat sein heissgeliebtes Walross Rupert wiedergefunden. Alle freuen sich und die Sterne tanzen " +
                    "um dieses freudiges Erlebnus mitzufeiern. Der Adoptionsservice hofft, dass in Zukunft keine Trennung " +
                    "mehr erfolgt und wünscht alles Gute.";
        }

        return String.format("Herzlichen Glückwunsch %s, \n" +
                "Ihr neues Haustier %s zieht morgen bei Ihnen ein.\n" +
                "Ihr AdoptionsService des Vertrauens",
                holder.getFirstName(), petName);
    }
}
