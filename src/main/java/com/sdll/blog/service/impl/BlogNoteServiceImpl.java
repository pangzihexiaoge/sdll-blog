package com.sdll.blog.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdll.blog.dao.BlogNoteMapper;
import com.sdll.blog.pojo.BlogNote;
import com.sdll.blog.service.IBlogNoteService;
@Service
@Transactional
public class BlogNoteServiceImpl implements IBlogNoteService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	BlogNoteMapper blogNoteMapper;
	
	public int insertBlogNote(BlogNote blogNote) {
		if(blogNote.getId() == null || "".equals(blogNote.getId())) {
			blogNote.setCreateTime(new Timestamp(System.currentTimeMillis()));
			blogNote.setId(UUID.randomUUID().toString().replace("-", ""));
		}
		blogNote.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return blogNoteMapper.insert(blogNote);
	}

	public BlogNote getBlogNoteUpdate() {
		BlogNote blogNote = blogNoteMapper.selectByUpdate();
		return blogNote;
	}

	public List<BlogNote> listBlogNote() {
		// TODO Auto-generated method stub
		return blogNoteMapper.listBlogNote();
	}

	public BlogNote getByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogNoteMapper.selectByPrimaryKey(id);
	}

}
