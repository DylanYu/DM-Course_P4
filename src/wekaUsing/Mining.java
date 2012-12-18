package wekaUsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesSimple;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils.DataSource;

public class Mining {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Classifier classifier1 = new J48();
		Classifier classifier2 = new J48();
		Classifier classifier3 = new J48();
		Classifier classifier4 = new J48();
		Classifier classifier5 = new J48();
		Classifier classifier6 = new J48();
		Classifier classifier7 = new J48();
		
//		Classifier classifier1 = new NaiveBayes();
//		Classifier classifier2 = new NaiveBayes();
//		Classifier classifier3 = new NaiveBayes();
//		Classifier classifier4 = new NaiveBayes();
//		Classifier classifier5 = new NaiveBayes();
//		Classifier classifier6 = new NaiveBayes();
//		Classifier classifier7 = new NaiveBayes();

		DataSource trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_1.arff");
		Instances 	instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		long t0 = new Date().getTime();
		classifier1.buildClassifier(instancesTrain);
		long t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);
		
		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_2.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier2.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);

		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_3.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier3.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);
		
		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_4.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier4.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);
		
		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_5.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier5.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);
		
		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_6.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier6.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);
		
		trainSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_7.arff");
		instancesTrain = trainSource.getDataSet();
		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
		t0 = new Date().getTime();
		classifier7.buildClassifier(instancesTrain);
		t1 =  new Date().getTime();
		System.out.println("J48 time used:" + (double)(t1 - t0) / 1000);

		System.out.println("training finished");
		
		DataSource testSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_10.arff");
		Instances 	instancesTest = testSource.getDataSet();
		instancesTest.setClassIndex(instancesTest.numAttributes() - 1);

		double numOfInstances = instancesTest.numInstances();
		
		/**
		 * take care of the filename!!!
		 */
		FileOutputStream out = new FileOutputStream("outputVoiceOnly.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
//		ArrayList<Double> list0 = new ArrayList<Double>();
//		ArrayList<Double> list1 = new ArrayList<Double>();
		
//		int J48CorrentCount = 0;
//		int NBCorrentCount = 0;
		for(int i = 0; i < numOfInstances; i++) {
			double sum_d0 = 0;
			double sum_d1 = 0;
			
			System.out.println(i + "::::::::::::");
			double[] distribution;
			distribution = classifier1.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("1-d0:" + distribution[0] + ", d1:" + distribution[1]);
			distribution = classifier2.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("2-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier3.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("3-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier4.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("4-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier5.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("5-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier6.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("6-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier7.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
//			System.out.println("7-d0:" + distribution[0] + ", d2:" + distribution[1]);
			
			double d0 = sum_d0 / 7;
			double d1 = sum_d1 / 7;
//			list0.add(d0);
//			list1.add(d1);
			double customerID = instancesTest.instance(i).value(0);
			bw.write(String.valueOf((int)customerID) + ",");
			bw.write(String.valueOf(d0) + ",");
			bw.write(String.valueOf(d1));
			bw.newLine();
			if(i % 10000 == 0)
				bw.flush();
//			System.out.println("d0:" + d0 + ", d1:" + d1);
//			System.out.println("============================");
		}
		bw.close();
		out.close();
//		System.out.println("precision:" + (double)J48CorrentCount / numOfInstances);
//		System.out.println("1:J48 time used:" + (double)(t1 - t0) / 1000);
	}
}