package com.sony.servlet;

public class Student {
	private int id;
	private String name;
	private float physics;
	private float maths;
	private float chemistry;

	public Student(int id, String name, float physics, float maths, float chemistry) {
		super();
		this.id = id;
		this.name = name;
		this.physics = physics;
		this.maths = maths;
		this.chemistry = chemistry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPhysics() {
		return physics;
	}

	public Student(String name, float physics, float maths, float chemistry) {
		super();
		this.name = name;
		this.physics = physics;
		this.maths = maths;
		this.chemistry = chemistry;
	}

	public Student(int id) {
		super();
		this.id = id;
	}

	public void setPhysics(float physics) {
		this.physics = physics;
	}

	public float getMaths() {
		return maths;
	}

	public void setMaths(float maths) {
		this.maths = maths;
	}

	public float getChemistry() {
		return chemistry;
	}

	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}

}
