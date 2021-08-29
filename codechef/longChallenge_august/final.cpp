#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int T;
  cin >> T;
  while(T--) {
    ll nval, mval;
    cin>>nval>>mval;

    vector<pair<int,int>>vp;
    for (int i=0; i < mval; i++)
    {
      ll x, y;
      cin>>x>>y;
      vp.push_back({x,y});
    }

    sort(vp.begin(), vp.end(), greater<pair<int,int>>());
    
    ll gcd=1;
    ll remender=nval;
    ll result=0;
    

    for (int i=0; i<mval && remender>0; i++){
        ll a= vp[i].first,b=vp[i].second;
        gcd = gcd*b/__gcd(gcd,b);
        result += (remender-nval/gcd)*a;
        remender= nval/gcd;
    }

    cout <<result<<endl;
  }
  return 0;
}