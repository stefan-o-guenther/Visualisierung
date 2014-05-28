package Rechnernetze.TCP_Fairness;


public abstract class PointAbstract implements Point {

	public PointAbstract() {
		
	}
	
	public PointAbstract(Integer connection1, Integer connection2) {
		try {
			if ((connection1 == null) || (connection2 == null)) {
				throw new NullPointerException();
			}
			if ((connection1 < 0) || (connection2 < 0)) {
				throw new IllegalArgumentException();
			}
			this.connection1 = connection1;
			this.connection2 = connection2;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Integer connection1;
	protected Integer connection2;
	
	@Override
	public Integer getConnection1() {
		return this.connection1;
	}

	@Override
	public void setConnection1(Integer connection1) {
		try {
			if (connection1 == null) {
				throw new NullPointerException();
			}
			if (connection1 < 0) {
				throw new IllegalArgumentException();
			}
			this.connection1 = connection1;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getConnection2() {
		return this.connection2;
	}

	@Override
	public void setConnection2(Integer connection2) {
		try {
			if (connection2 == null) {
				throw new NullPointerException();
			}
			if (connection2 < 0) {
				throw new IllegalArgumentException();
			}
			this.connection2 = connection2;
		} catch (Exception ex) {
			throw ex;
		}
	}
}