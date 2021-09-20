#include <bits/stdc++.h>
using namespace std;

#define vi          vector<int>
#define vll         vector<long long>
#define pll         pair<long long, long long>
#define pii         pair<int, int>
#define ld          long double
#define ff          first
#define ss          second
#define vs          vector<string>
#define vpll        vector<pll>
#define vb          vector<bool>
#define mp          make_pair
#define pb          push_back
#define endl        '\n'

const long long INF       = 2e18;
const long long mod       = 1000000007;
const long long mod2      = 998244353;



signed main(){

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif



    int tc = 0, tt = 1;
    cin >> tt;
    while (tc++ < tt)
    {

        long long n, k;
        cin >> n >> k;

        vll arr(n);
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }

        bool allZero = true;
        for(auto z: arr){
            if(z > 0){
                allZero = false;
                break;
            }
        }

        if(allZero){
            cout << 0 << '\n';
            continue;
        }

        if(k == 0){
            long long sol = 0;
            for(auto z: arr){
                sol += z;
            }
            cout << sol << '\n';
            continue;
        }

        set<long long> pos;
        set<long long, greater<long long>> posG;
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                pos.insert(i);
                posG.insert(i);
                pos.insert(i+n);
                posG.insert(i+n);
            }
        }

        vll ans_arr(n, k);

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                long long val1 = *pos.lower_bound(i);
                long long val2 = *posG.lower_bound(i+n);
                long long dist = min(abs(val1 - i), abs(val2 - (i+n)));
                ans_arr[i] -= dist;
            }
        }

        for(auto &z: ans_arr){
            if(z < 0){
                z = 0;
            }
        }


        long long finalSum = 0;
        for(auto z: arr){
            finalSum += z;
        }

        for(auto z: ans_arr){
            finalSum += 2LL*z;
        }

        cout << finalSum << '\n';
    }
    return 0;
}