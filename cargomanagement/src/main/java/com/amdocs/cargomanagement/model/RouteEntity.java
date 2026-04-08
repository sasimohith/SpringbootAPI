package com.amdocs.cargomanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RouteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Route_id")
	private int routeid;
	@Column(name = "BoardingPoint")
	@JsonAlias({ "boarding_point", "boardingPoint" })
	private String boardingPoint;

	@Column(name = "DeparturePoint")
	@JsonAlias({ "departure_point", "departurePoint" })
	private String departurePoint;

	@Column(name = "TravelStartDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date travelstartDate;

	@Column(name = "TravelEndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date travelendDate;

	@ManyToOne
	@JoinColumn(name = "dno")
	private Driver drivers;
}
