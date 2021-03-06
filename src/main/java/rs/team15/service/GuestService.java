package rs.team15.service;

import java.util.Collection;

import rs.team15.model.FriendInvitation;
import rs.team15.model.Friendship;
import rs.team15.model.Guest;
import rs.team15.model.Reservation;
import rs.team15.model.User;


public interface GuestService {

	Guest getGuest(Long id);
	
	Collection<Guest> getGuestByFirstName(String fname);

    User create(Guest guest);
    
    Collection<Guest> findAll();
    
    Collection<User> findFriendsIAccept(Long id);
    
    Collection<User> findReq(Long id);
    
    Friendship addFriend(Long senderId, Long receiverId);
    
    Friendship accept(Long senderId, Long receiverId);

	Collection<User> findFriendsIAdd(Long id);

	Friendship reject(Long senderId, Long receiverId);

	Friendship deleteF(Long senderId, Long receiverId);
	
	
	
	FriendInvitation addFriendInvite(Long senderId, Long receiverId, Reservation r);
	
	Collection<FriendInvitation> findFI(Long id);
	
	Collection<FriendInvitation> getByReservation_rsid(Long resid);
	
	FriendInvitation acceptInvite(Long fid);
	FriendInvitation rejectInvite(Long fid);
	
	Collection<FriendInvitation> findFIAccept(String status, Long senderid);
	
	FriendInvitation findFIAcceptForDelete(String status, Long rId, Long resId);
	
	Collection<FriendInvitation> findFISendForDelete( Long sId, Long resId);
}
