package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.MeetUser;
import com.ccgj.database.custom.beans.MeetCustom;

public interface MeetUserService {
    public int insertMeetUser(MeetUser meetUser);
    public List<MeetUser> searchMeetUserByMeetId(Integer meetId);
    public MeetCustom searchMeetCustomByMeetId(Integer meetId);
    public int deleteMeetUserByMeetId(Integer meetId);
}
