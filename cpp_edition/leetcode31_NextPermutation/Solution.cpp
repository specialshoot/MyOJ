#include <iostream>
#include <functional>
#include <algorithm>
#include <vector>
using namespace std;

class Solution{
    public:
        void nextPermutation(vector<int> &nums){
            next_permutation(nums.begin(),nums.end());
        }
        template<typename BidiIt>
        bool next_permutation(BidiIt first,BidiIt last){
            const auto rfirst=reverse_iterator<BidiIt>(last);//反转的第一个即最后一个
            const auto rlast=reverse_iterator<BidiIt>(first);//反转的最后一个即第一个

            auto pivot=next(rfirst);    //最后一个的指针

            //找到前一个小于后一个的编号
            while(pivot!=rlast && *pivot >= *prev(pivot))
                ++pivot;

            if(pivot==rlast){
                reverse(rfirst,rlast);  //如果从最后一个到第一个元素从小到大,则反转整个数组
                return false;
            }

            auto change=find_if(rfirst,pivot,bind1st(less<int>(),*pivot));//找到从rfirst到pivot即pivot到最后一个元素之间第一个小于pivot指向元素的下标
            swap(*change,*pivot);   //交换元素
            reverse(rfirst,pivot);  //反转从pivot到最后一个之间的元素
            return true;
        }
};

int main() {
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(5);
    Solution s;
    s.nextPermutation(nums);
    vector<int>::iterator it;
    for(it=nums.begin();it!=nums.end();it++)
            cout<<*it<<" ";
    cout<<endl;
    return 0;
}
