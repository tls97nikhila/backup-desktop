package com.stackroute.muzixapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.model.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	//implement all the methods
	@Override
	public boolean saveTrack(Track track) {


		sessionFactory.getCurrentSession().save(track);

		return true;
	}

	@Override
	public boolean deleteTrack(int id) {

		return false;
	}

	@Override
	public List<Track> getAllTracks() {
		List<Track> alltracks= sessionFactory.getCurrentSession().createQuery("from Track order by id").list();
		return alltracks;
	}

	@Override
	public Track getTrackById(int id) {

		return null;
	}

	@Override
	public boolean UpdateTrack(Track track) {
		sessionFactory.getCurrentSession().update(track);
		return true;
	}

}
