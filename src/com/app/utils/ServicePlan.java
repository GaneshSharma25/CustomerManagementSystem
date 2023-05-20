package com.app.utils;

public enum ServicePlan {
	
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	private int planCharge;
	
	private ServicePlan(int planCharge) {
		this.planCharge = planCharge; 
	}

	public int getPlanCharge() {
		return planCharge;
	}

	public void setPlanCharge(int planCharge) {
		this.planCharge = planCharge;
	}
	
  @Override
  public String toString() {
	  return name()+" PlanCost"+this.planCharge;
  }	

}
