# [Gold IV] Square, Not Rectangle - 20033 

[문제 링크](https://www.acmicpc.net/problem/20033) 

### 성능 요약

메모리: 57104 KB, 시간: 296 ms

### 분류

자료 구조, 이분 탐색

### 제출 일자

2025년 11월 3일 21:00:25

### 문제 설명

<p>A histogram is a polygon made by aligning $N$ adjacent rectangles that share a common base line. Each rectangle is called a bar. The $i$-th bar from the left has width 1 and height $H_i$.</p>

<p>Your goal is to find the area of the largest rectangle contained in the given histogram, such that one of the sides is parallel to the base line.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/c2f4b765-52f0-45c6-87e8-52e2c5760d0e/" style="width: 420px; height: 131px;"></p>

<p style="text-align: center;"><em>Figure 1. The histogram given in the example, with the largest rectangle shown on the right.</em></p>

<p>Actually, no, you have to find the largest <strong>square</strong>. Since the area of a square is determined by its side length, you are required to output the <strong>side length</strong> instead of the area.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/56b37985-3029-4879-90cb-4b6cdba5d798/" style="width: 419px; height: 131px;"></p>

<p style="text-align: center;"><em>Figure 2. The histogram given in the example, with the largest <strong>square</strong> shown on the right.</em></p>

### 입력 

 <p>On the first line, a single integer $N$ is given, where $1 \le N \leq 300\,000$.</p>

<p>On the next line, $N$ space-separated integers $H_1, H_2, \cdots, H_N$, are given. $H_i$ $(1 \le H_i \le 10^9)$ is the height of the $i$-th bar. </p>

### 출력 

 <p>Output the side length of the largest square in the histogram, such that one of the sides is parallel to the base line.</p>

