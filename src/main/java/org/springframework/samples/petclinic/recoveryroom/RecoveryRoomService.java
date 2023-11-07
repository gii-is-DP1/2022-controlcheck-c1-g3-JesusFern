package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {
    @Autowired
    private RecoveryRoomRepository rrr;

    @Transactional
    public List<RecoveryRoom> getAll(){
        return rrr.findAll();
    }
    @Transactional
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return rrr.findAllRecoveryRoomTypes();
    }
    @Transactional
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return rrr.getRecoveryRoomType(typeName);
    }
    @Transactional(rollbackFor = DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        RecoveryRoom OldRr = rrr.findByName(p.name);
        if(OldRr == null){
            rrr.save(p);
        }else{
            throw new DuplicatedRoomNameException();
        }
        return null;       
    }

    
}
