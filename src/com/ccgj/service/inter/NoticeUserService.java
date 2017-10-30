package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.custom.beans.NoticeCustom;

public interface NoticeUserService {
     public List<NoticeUser> searchByNoticeId(Integer noticeId);
     public int insertNoticeUser(NoticeUser noticeUser);
     public int deleteNoticeUserById(Integer id);
     
     public NoticeCustom searchNoticeCustomById(Integer id);
     
     public int deleteNoticeUserByNoticeId(Integer noticeId);
}
