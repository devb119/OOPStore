/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Duc Anh.Nguyen
 */
public class Shift {
    int shiftId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    double hour;
    public Shift(int shiftId, String startTime, String endTime, double hour)
            {
                this.shiftId = shiftId;
                this.startTime = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                this.endTime = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                this.hour = hour;
            }
    public LocalDateTime getStartTime()
        {
               return startTime;
        }
    public LocalDateTime getEndTime()
        {
               return endTime;
        }
    public int getShiftId()
        {
            return shiftId;    
        }
    public double getHour()
        {
            return hour;    
        }
    public void setStartTime(LocalDateTime startTime)
        {
            this.startTime = startTime;
        }
    public void setEndTime(LocalDateTime endTime)
        {
            this.endTime = endTime;
        }
}
