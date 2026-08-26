
                r++;
            }

            if (count == k && (r - l) < min) {
                min = r - l;
                x = l;
                y = r - 1;
            }
        }

        if (x == -1)
            return "";

        return s.substring(x, y + 1);
    }
}
