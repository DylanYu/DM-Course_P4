wfile = open('analysis/analysis data', 'w')

#with open('smetxt/SME_VoiceOnly_Subscribers.txt') as rfile:
with open('smetxt/SME_VoiceBB_Subscribers.txt') as rfile:
    line = rfile.readline()
    line = rfile.readline()
    total_count = 0
    ter_count = 0
    ter_2011 = 0
    count_not2011 = 0
    count_80 = 0;
    count_80_90 = 0;
    count_90_95 = 0;
    count_95_00 = 0;
    count_00_05 = 0;
    count_05_ = 0;
    while line:
        strs = line.split(',')
        if not strs[8] == '':
            if not strs[7] == '':
                act_time = strs[7]
                act_year = int((act_time.split(' ')[0]).split('-')[2])
                if act_year < 1980:
                    count_80 += 1
                elif act_year < 1990:
                    count_80_90 += 1
                elif act_year < 1995:
                    count_90_95 += 1
                elif act_year < 2000:
                    count_95_00 += 1
                elif act_year < 2005:
                    count_00_05 += 1
                else:
                    count_05_ += 1
            ter_count += 1 
            ter_time = strs[7]
            ter_year = (ter_time.split(' ')[0]).split('-')[2]
            wfile.write(ter_year+'\n')
            #print ter_year
            #if not ter_year == '2011':
            if ter_year == '2011':
                ter_2011 += 1
            #print 'ter_year:', ter_year
        total_count += 1
        #print total_count
        line = rfile.readline()
    print ter_count
    print ter_2011
    print total_count
    print '<80:', count_80 / float(ter_count)
    print '<90:', count_80_90 / float(ter_count)
    print '<95:', count_90_95 / float(ter_count)
    print '<00:', count_95_00 / float(ter_count)
    print '<05:', count_00_05 / float(ter_count)
    print '>05:', count_05_ / float(ter_count)

