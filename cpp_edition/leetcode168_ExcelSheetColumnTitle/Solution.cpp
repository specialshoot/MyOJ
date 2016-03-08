#include <iostream>
#include <functional>
#include <algorithm>
#include <vector>
using namespace std;

class Solution{
    public:
        string convertToTitle(int n) {
            string s="";
            while(n>0){
                s=(char)((n-1)%26+'A')+s;
                n=(n-1)/26;
            }
            return s;
        }
};

int main() {
    Solution s;
    cout<<s.convertToTitle(17)<<endl;
    return 0;
}
