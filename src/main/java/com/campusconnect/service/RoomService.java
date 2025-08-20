package com.campusconnect.service;

import com.campusconnect.dto.RoomDto;
import com.campusconnect.entity.Room;
import com.campusconnect.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        return roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {
        if(!roomRepository.existsById(roomId)) {
            throw new RuntimeException("Room not found : "+roomId);
        }
        roomRepository.deleteById(roomId);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
