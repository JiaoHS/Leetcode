package com.xjtu.ssmidea.jianzhioffer;

/**
 * @auther coraljiao
 * @date 2019/4/2 19:54
 * @description
 */
public class day03 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int minGasStation(int numOfGS, int[] distOfGS,
                             int[] allowedGasoline, int distance,
                             int initialGasoline)
    {
        //numOfGS加油站个数的整数
        //加油站与家的距离列表distOfGS
        //allowedGasoline每个加油站可供汽油量的大小
        //distance家月公司的距离
        //initialGasoline汽油的初始值
        // WRITE YOUR CODE HERE
        return 0;
    }

    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations)
    {
        //ans表示最后结果，即最小加油次数
        //pos表示当前卡车位置
        //tank表示油缸中油的数量
        //que优先队列中存放之前能通过的各个加油站的最大加油量Bi
        priority_queue<pair<int,int> > que;
        int ans=0,pos=0,tank=startFuel;
        vector<int> c;
        c.push_back(target);//这里要把终点也算进去
        c.push_back(0);//0代表终点没有油桶
        stations.push_back(c);
        for(int i=0;i<stations.size();i++)
        {
            int curDist=stations[i][0]-pos;   //curDist表示到达下一个临时终点(加油站)的距离
            while(curDist>tank)      //当前油不够到下一个终点
            {
                if(que.empty())
                {
                    return -1;
                }
                pair<int,int> temp=que.top();
                que.pop();
                tank+=temp.first;         //不断加油,直到能到达下一个终点
                ans++;
            }
            tank-=curDist;          //跑到下一个终点，消耗 curDist数量的油
            pos=stations[i][0];               //到达下一个加油站，取得该加油站的油，放在优先队列中，以便后面使用
            que.push(make_pair(stations[i][1],i));

        }
        return ans;
    }



//    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
//        int stationnum=stations.size();
//
//        int cur=startFuel;
//        int i=0;
//        int cnt=0;
//        priority_queue<int>que;
//        while(true)
//        {
//            if(cur>=target)return cnt;
//            while(i<stationnum&&stations[i][0]<=cur)
//                que.push(stations[i++][1]);
//            if(que.empty())return -1;
//            cur+=que.top();que.pop();
//            cnt++;
//        }
//        return -1;
//    }
//
//    int minRefuelStops(int target, int startFuel, vector<vector<int>> &stations) {
//        priority_queue<int> queue;
//        int pos = 0, ans = 0;
//        stations.push_back({target, 0});//我这里把终点加进去方便程序比较
//        while (startFuel < target) {    //当油量不能撑到终点时循环
//            while (pos < stations.size() - 1 && startFuel >= stations[pos][0])//把车当前油量所能开到的每一个加油站的油量都记下来
//                queue.push(stations[pos++][1]);
//            while (startFuel < stations[pos][0]) {//遇到下一站开不到则加油,使用priority_queue确保加的油量是经过的加油站里面最多的，把终点加进stations使得这一步逻辑就很方便
//                if (queue.empty())                //把经过的所有加油站的油都加上都到不了，那就肯定到不了
//                    return -1;
//                startFuel += queue.top();         //加油
//                queue.pop();
//                ++ans;
//            }
//        }
//        return ans;
//    }
}
