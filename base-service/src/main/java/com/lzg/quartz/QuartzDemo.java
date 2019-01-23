package com.lzg.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘志钢
 */
public class QuartzDemo {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail job = JobBuilder.newJob(JobDemo.class)
                .withIdentity("jobDemo", "group1")
                .usingJobData("jobSays", "hello world")
                .usingJobData("myFloatValue", 3.14f)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triger1", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        scheduler.scheduleJob(job, trigger);

        TimeUnit.MINUTES.sleep(1);

        scheduler.shutdown();
    }


    public static class JobDemo implements Job {

        private float myFloatValue;

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            JobKey key = context.getJobDetail().getKey();

            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            String jobSays = dataMap.getString("jobSays");
        //    float myFloatValue = dataMap.getFloat("myFloatValue");

            System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
        }

        public void setMyFloatValue(float myFloatValue) {
            this.myFloatValue = myFloatValue;
        }

    }

}
