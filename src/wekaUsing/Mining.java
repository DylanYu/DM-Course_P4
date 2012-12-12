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
		//Classifier m_classifier = new J48();
		Classifier classifier1 = new NaiveBayes();
		Classifier classifier2 = new NaiveBayes();
		Classifier classifier3 = new NaiveBayes();
		Classifier classifier4 = new NaiveBayes();
		Classifier classifier5 = new NaiveBayes();
		Classifier classifier6 = new NaiveBayes();
		Classifier classifier7 = new NaiveBayes();

		DataSource trainSource1 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_1.arff");
		DataSource trainSource2 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_2.arff");
		DataSource trainSource3 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_3.arff");
		DataSource trainSource4 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_4.arff");
		DataSource trainSource5 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_5.arff");
		DataSource trainSource6 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_6.arff");
		DataSource trainSource7 = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_7.arff");
	
		Instances 	instancesTrain1 = trainSource1.getDataSet();
		instancesTrain1.setClassIndex(instancesTrain1.numAttributes() - 1);
		Instances 	instancesTrain2 = trainSource2.getDataSet();
		instancesTrain2.setClassIndex(instancesTrain2.numAttributes() - 1);
		Instances 	instancesTrain3 = trainSource3.getDataSet();
		instancesTrain3.setClassIndex(instancesTrain3.numAttributes() - 1);
		Instances 	instancesTrain4 = trainSource4.getDataSet();
		instancesTrain4.setClassIndex(instancesTrain4.numAttributes() - 1);
		Instances 	instancesTrain5 = trainSource5.getDataSet();
		instancesTrain5.setClassIndex(instancesTrain5.numAttributes() - 1);
		Instances 	instancesTrain6 = trainSource6.getDataSet();
		instancesTrain6.setClassIndex(instancesTrain6.numAttributes() - 1);
		Instances 	instancesTrain7 = trainSource7.getDataSet();
		instancesTrain7.setClassIndex(instancesTrain7.numAttributes() - 1);
		
		System.out.println("read finished");
		long t0 = new Date().getTime();
		classifier1.buildClassifier(instancesTrain1);
		long t1 =  new Date().getTime();
		System.out.println("1:time used:" + (double)(t1 - t0) / 1000);
		classifier2.buildClassifier(instancesTrain2);
		long t2 = new Date().getTime();
		System.out.println("2:time used:" + (double)(t2 - t1) / 1000);
		classifier3.buildClassifier(instancesTrain3);
		long t3 = new Date().getTime();
		System.out.println("3:time used:" + (double)(t3 - t2) / 1000);
		classifier4.buildClassifier(instancesTrain4);
		long t4 = new Date().getTime();
		System.out.println("4:time used:" + (double)(t4 - t3) / 1000);
		classifier5.buildClassifier(instancesTrain5);
		long t5 = new Date().getTime();
		System.out.println("5:time used:" + (double)(t5 - t4) / 1000);
		classifier6.buildClassifier(instancesTrain6);
		long t6 = new Date().getTime();
		System.out.println("6:time used:" + (double)(t6 - t5) / 1000);
		classifier7.buildClassifier(instancesTrain7);
		long t7 = new Date().getTime();
		System.out.println("7:time used:" + (double)(t7 - t6) / 1000);
		System.out.println("training finished");
		
		DataSource testSource = new DataSource("D:\\Study\\DataMining\\Project_4\\dataMining\\voice\\Weka_Instances_v2\\Data_10.arff");
		Instances 	instancesTest = testSource.getDataSet();
		instancesTest.setClassIndex(instancesTest.numAttributes() - 1);

		double sum = instancesTest.numInstances();
		
		FileOutputStream out = new FileOutputStream("output.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		ArrayList<Double> list0 = new ArrayList<Double>();
		ArrayList<Double> list1 = new ArrayList<Double>();
		
		for(int i = 0; i < sum; i++) {
			double sum_d0 = 0;
			double sum_d1 = 0;
			System.out.println(i + "::::::::::::");
//			double result = classifier1.classifyInstance(instancesTrain7.instance(i));
//			double fact = instancesTrain7.instance(i).classValue();
//			System.out.println("result:" + result + ", fact:" + fact);
			
			double[] distribution;
			distribution = classifier1.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("1-d0:" + distribution[0] + ", d1:" + distribution[1]);
			distribution = classifier2.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("2-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier3.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("3-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier4.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("4-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier5.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("5-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier6.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("6-d0:" + distribution[0] + ", d2:" + distribution[1]);
			distribution = classifier7.distributionForInstance(instancesTest.instance(i));
			sum_d0 += distribution[0];
			sum_d1 += distribution[1];
			System.out.println("7-d0:" + distribution[0] + ", d2:" + distribution[1]);
			
			double d0 = sum_d0 / 7;
			double d1 = sum_d1 / 7;
			list0.add(d0);
			list1.add(d1);
			bw.write(String.valueOf(d0) + ",");
			bw.write(String.valueOf(d1));
			bw.write("\n");
			if(i % 10000 == 0)
				bw.flush();
			System.out.println("d0:" + distribution[0] + ", d2:" + distribution[1]);
			System.out.println("============================");
		}
		bw.close();
		//System.out.println("precision:" + (double)count / sum);
	}
}